pragma solidity ^0.5.2;

import "../registry/AbstractRNS.sol";

/**
 * @title SubdomainRegistrar
 * Allows anyone to create subnodes under a given and owned RNS node.
 */
contract SubdomainRegistrar {
  AbstractRNS public rns;
  bytes32 public rootNode;
  address owner;

  modifier onlyOwner () {
    require(msg.sender == owner);
    _;
  }

  /**
   * @dev Constructor
   * @param _rns AbstractRNS RNS registry address
   * @param _rootNode An owned node. The contract emits subnodes under this node.
   */
  constructor (AbstractRNS _rns, bytes32 _rootNode) public {
    rns = _rns;
    rootNode = _rootNode;
    owner = msg.sender;
  }

  /**
   * @dev Registers a new subnode under the root node. The new node owner is the sender
   * @param label bytres32 The label of the new subnode.
   */
  function register (bytes32 label) public {
    bytes32 node = keccak256(abi.encodePacked(rootNode, label));
    require(rns.owner(node) == address(0));

    rns.setSubnodeOwner(rootNode, label, msg.sender);
  }

  /**
   * @dev Transfers back the root node ownership to the contract's owner.
   */
  function transferBack () public onlyOwner() {
    rns.setOwner(rootNode, owner);
  }
}

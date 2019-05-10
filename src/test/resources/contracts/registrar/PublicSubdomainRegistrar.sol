pragma solidity ^0.5.2;

import "../registry/AbstractRNS.sol";

/**
 * @title PublicSubdomainRegistrar
 * Allows anyone to create subnodes under any delegated RNS node.
 */
contract PublicSubdomainRegistrar {
    AbstractRNS public rns;

    mapping (bytes32 => address) delegated;

    modifier onlyOwned (bytes32 node) {
        require(rns.owner(node) == address(this));
        _;
    }

    modifier onlyPreviousOwner (bytes32 node) {
        require(msg.sender == delegated[node]);
        _;
    }

    /**
     * @dev Constructor
     * @param _rns AbstractRNS RNS registry address
     */
    constructor (AbstractRNS _rns) public {
        rns = _rns;
    }

    /**
     * @dev Delegates an owned node to this contract.
     * @param node bytes32 The delegated RNS node.
     */
    function delegate (bytes32 node) public onlyOwned(node) {
        delegated[node] = msg.sender;
    }

    /**
     * @dev Check if a node is delegated to this contract.
     * @param node bytes32 An RNS node.
     * @return if the node is delgated
     */
    function isDelegated (bytes32 node) public view returns (bool) {
        return delegated[node] != address(0);
    }

    /**
     * @dev Transfers back a delegated node to who delegated it.
     * @param node bytes32 Node to retrive.
     */
    function transferBack (bytes32 node) public onlyPreviousOwner(node) {
        rns.setOwner(node, delegated[node]);
        delegated[node] = address(0);
    }

    /**
     * @dev Registrers a subnode under a given and delegated node.
     * @param node bytes32 The parent node.
     * @param label bytes32 The hash of the label specifying the subnode.
     */
    function register (bytes32 node, bytes32 label) public {
        address subnodeOwner = rns.owner(keccak256(abi.encodePacked(node, label)));
        require(subnodeOwner == address(0));

        rns.setSubnodeOwner(node, label, msg.sender);
    }
}

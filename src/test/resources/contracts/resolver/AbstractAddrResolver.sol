pragma solidity ^0.5.2;

import "./AbstractResolver.sol";

contract AbstractAddrResolver is AbstractResolver {
    function addr(bytes32 node) public view returns (address ret);
    function setAddr(bytes32 node, address addrValue) public;

    event AddrChanged(bytes32 indexed node, address addr);
}

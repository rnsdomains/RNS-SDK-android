pragma solidity ^0.5.2;

contract AbstractResolver {
    function supportsInterface(bytes4 interfaceID) public pure returns (bool);
}

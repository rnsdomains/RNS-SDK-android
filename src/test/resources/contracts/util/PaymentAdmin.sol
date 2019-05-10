pragma solidity ^0.5.2;

import "../token/ERC20Basic.sol";

contract PaymentAdmin {
    address payable public owner = msg.sender;

    modifier onlyOwner () {
        require(msg.sender == owner);
        _;
    }

    function () external payable {
        owner.transfer(msg.value);
    }

    function retrieveTokens (address receiver, ERC20Basic token) public onlyOwner() {
        uint256 balance = token.balanceOf(address(this));
        token.transfer(receiver, balance);
    }

    function transfer (address receiver, ERC20Basic token, uint256 value) public onlyOwner() {
        token.transfer(receiver, value);
    }
}

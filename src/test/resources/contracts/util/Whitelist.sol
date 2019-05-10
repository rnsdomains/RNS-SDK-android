pragma solidity ^0.5.2;

import "./AbstractWhitelist.sol";

contract Whitelist is AbstractWhitelist {
	address public owner;

	mapping (address => bool) public isManager;
	mapping (address => uint) public whitelistedUntil;

	uint public whitelistedTime;

	modifier onlyOwner () {
		require(msg.sender == owner);
		_;
	}

	modifier onlyManagers () {
		require(isManager[msg.sender]);
		_;
	}

	constructor () public {
		owner = msg.sender;
		whitelistedTime = 1 days;
	}

	function addManager (address manager) public onlyOwner() {
		isManager[manager] = true;
	}

	function removeManager (address manager) public onlyOwner() {
		isManager[manager] = false;
	}

	function addWhitelisted (address whitelisted) public onlyManagers() {
		whitelistedUntil[whitelisted] = now + whitelistedTime;
	}

	function removeWhitelisted (address whitelisted) public onlyManagers() {
		whitelistedUntil[whitelisted] = 0;
	}

	function isWhitelisted (address whitelisted) public view returns (bool) {
		return whitelistedUntil[whitelisted] > now;
	}

	function setExpirationTime (uint time) public onlyOwner() {
		whitelistedTime = time;
	}
}

pragma solidity ^0.5.2;

contract AbstractWhitelist {
	function isWhitelisted (address whitelisted) public view returns (bool);
	function removeWhitelisted (address whitelisted) public;
}

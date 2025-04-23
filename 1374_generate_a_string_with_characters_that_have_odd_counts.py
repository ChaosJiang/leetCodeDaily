def generateTheString(n: int) -> str:
    """
    Generate a string with n characters such that each character occurs an odd number of times.

    Args:
        n: The length of the string to generate

    Returns:
        A string of n characters where each character appears an odd number of times
    """
    # If n is odd, we can simply return n 'a's
    if n % 2 == 1:
        return "a" * n

    # If n is even, we need n-1 'a's and 1 'b'
    # This ensures both characters appear an odd number of times
    return "a" * (n - 1) + "b"


# Example usage
if __name__ == "__main__":
    # Test cases
    print(f"Input: 4, Output: {generateTheString(4)}")
    print(f"Input: 2, Output: {generateTheString(2)}")
    print(f"Input: 7, Output: {generateTheString(7)}")

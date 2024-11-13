/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let currentIndex = 0, lastIndex = -1, length = 0, maxLength = 0;
    const charactersToLastFound = new Set();
    while (currentIndex < s.length) {
        const currentCharacter = s[currentIndex];
        if (charactersToLastFound.has(currentCharacter)) {
            while (s.charAt(++lastIndex) != currentCharacter) {
                charactersToLastFound.delete(s.charAt(lastIndex));
            }
        }
        charactersToLastFound.add(currentCharacter);
        length = currentIndex - lastIndex;
        maxLength = length > maxLength ? length : maxLength;
        currentIndex++;
    }
    return maxLength;
};

console.log(lengthOfLongestSubstring("pwwkew"))
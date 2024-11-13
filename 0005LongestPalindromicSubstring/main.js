/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
    let axis = 0, maxLength = 0, currentLength = 0, answer = [0, 0];
    while (axis < s.length) {
        let radius = 0;
        while (axis - radius >= 0 && axis + radius < s.length && s[axis - radius] === s[axis + radius]) {
            currentLength = 2 * radius + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                answer = [axis - radius, axis + radius + 1];
            }
            radius++;
        }

        radius = 0;
        while (axis - radius >= 0 && axis + radius - 1 < s.length && s[axis - radius] === s[axis + radius - 1]) {
            currentLength = 2 * radius;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                answer = [axis - radius, axis + radius];
            }
            radius++;
        }
        axis++;
    }
    return s.substring(answer[0], answer[1]);
}

console.log(longestPalindrome("cbbd"));

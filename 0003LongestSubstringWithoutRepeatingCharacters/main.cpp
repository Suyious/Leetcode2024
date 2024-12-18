#include <cstdio>
#include <string>
#include <set>    

using namespace std;

int lengthOfLongestSubstring(string s) {
    int len = 0;
    std::set<int> track;
    int i = 0, j = 0;

    while(j < s.length()) {
        while(track.find(s[j]) != track.end()) {
            track.erase(s[i]);
            i++;
        }
        track.insert(s[j]);
        len = max(len, j - i + 1);

        j++;
    }

    return len;
}

int main() {
    printf("%d\n", lengthOfLongestSubstring("abcabcbb"));
    printf("%d\n", lengthOfLongestSubstring("bbbbb"));
    printf("%d\n", lengthOfLongestSubstring("pwwkew"));
    return 0;
}
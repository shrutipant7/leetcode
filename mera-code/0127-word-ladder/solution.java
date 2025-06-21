class Solution {
      class Pair {
    String word;
    int level;

    public Pair(String word, int level) {
      this.word = word;
      this.level = level;
    }
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    // Initialise a set and put all valid words in it
    Set<String> set = new HashSet<>();
    for (String str : wordList) {
      set.add(str);
    }

    Queue<Pair> q = new ArrayDeque<>();
    q.add(new Pair(beginWord, 0));

    int len = beginWord.length();

    while (!q.isEmpty()) {
      Pair topWord = q.poll();
      if (topWord.word.equals(endWord)) return topWord.level + 1;
      for (int i = 0; i < len; i++) {
        for (int j = 0; j < 26; j++) {
          StringBuilder sb = new StringBuilder(topWord.word);
          char newCh = (char) ('a' + j);
          sb.setCharAt(i, newCh);
          String newWord = sb.toString();
          if (set.contains(newWord) && !(newWord.equals(topWord.word))) {
            q.add(new Pair(newWord, topWord.level + 1));
            set.remove(newWord);
          }
        }
      }
    }
    return 0;
  }
}

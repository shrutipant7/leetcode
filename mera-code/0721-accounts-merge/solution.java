class DisjointSet {
  List<Integer> size = new ArrayList<>();
  List<Integer> parent = new ArrayList<>();

  DisjointSet(int n) {
    for (int i = 0; i <= n; i++) {
      parent.add(i);
      size.add(1);
    }
  }

  void unionBySize(int u, int v) {
    int p_u = findUParent(u);
    int p_v = findUParent(v);
    if (p_u == p_v) return;
    if (size.get(p_u) <= size.get(p_v)) {
      parent.set(p_u, p_v);
      size.set(p_v, size.get(p_v) + size.get(p_u));

    } else if (size.get(p_u) > size.get(p_v)) {
      parent.set(p_v, p_u);
      size.set(p_u, size.get(p_u) + size.get(p_v));
    }
  }

  int findUParent(int u) {
    if (u == parent.get(u)) return u;
    int u_par = findUParent(parent.get(u));
    parent.set(u, u_par);
    return u_par;
  }
}

class Solution {
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    List<List<String>> ans = new ArrayList<>();
    int n = accounts.size();
    DisjointSet ds = new DisjointSet(n);
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<String> acc = accounts.get(i);
      for (int j = 1; j < acc.size(); j++) {
        if (!map.containsKey(acc.get(j))) map.put(acc.get(j), i);
        else {
          int v = map.get(acc.get(j));
          ds.unionBySize(i, v);
        }
      }
    }

    List<List<String>> mergedMail = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      mergedMail.add(new ArrayList<>());
    }
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      int p_u = ds.findUParent(entry.getValue());
      mergedMail.get(p_u).add(entry.getKey());
    }

    for (int i = 0; i < n; i++) {
      List<String> intRes = new ArrayList<>();
      List<String> it = mergedMail.get(i);
      if (it.size() == 0) continue;
      Collections.sort(it);
      intRes.add(accounts.get(i).get(0));
      intRes.addAll(it);
      ans.add(intRes);
    }
    return ans;
  }
}


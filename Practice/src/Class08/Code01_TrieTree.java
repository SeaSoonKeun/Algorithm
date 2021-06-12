package Class08;

import javax.xml.xpath.XPath;

/**
 * @Auther: xucg
 * @Date: 2021/6/17 - 06 - 17 - 11:28 上午
 * @Description: TrieTree
 *
 * 字符串类型的数组加入到哈希表中，O(M) M为字符串长度，每次需要计算一个哈希值。
 * 查看几次和前缀 哈希表没有 前缀树强大
 *
 * 前缀树节点类型（以底层节点是否存在标记路是否存在）nexts节点的路Node1[26]
 *
 * 插入 搜索 搜索前缀 类似
 *
 * 删除 需要注意内存溢出问题
 */
public class Code01_TrieTree {
    public class Node{
        public int pass;
        public int end;
        public Node[] nexts;
        public Node(){
            pass = 0;
            end = 0;
            nexts = new Node[26];
        }
    }
    public class Trie{
        private Node root;

        public Trie(){
            root = new Node();
        }
        // 字符串挂树上
        public void insert(String word){
            if (word == null){
                return;
            }
            char[] str = word.toCharArray();
            // 头结点
            Node node = root;
            // 头结点p++
            node.pass++;
            // 路
            int path = 0;
            for (int i = 0; i < str.length; i++) {
                path = str[i] - 'a';

                if (node.nexts[path] == null){
                    // 新开路
                    node.nexts[path] = new Node();
                }
                // 循环下去
                node = node.nexts[path];
                // 经过++
                node.pass++;
            }
                // 字符串遍历结束，end出现
            node.end++;
        }

        // 字符串加入过几回--search 看end
        public int search(String word){
            if (word == null){
                return 0;
            }
            char[] str = word.toCharArray();
            Node node = root;
            int ans = 0;
            // 如果四个节点循环内有三条路
            for (int i = 0; i < str.length; i++) {
                int path = str[i] - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                // 注意此处的边界。最后一个node的nexts不为空，跳到尾部节点，跳出循坏，返回其end值
                if (node.nexts[path] != null){
                    node = node.nexts[path];
                }
            }
            return node.end;
        }

        // 查前缀-- prefixSearch 看pass, 与查找类似，只是返回值不同。
        public int prefixSearch(String prefix){
            if (prefix == null){
                return 0;
            }
            Node node = root;
            char[] pre = prefix.toCharArray();
            for (int i = 0; i < pre.length; i++){
                int path = pre[i] - 'a';
                if (node.nexts[path] == null){
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
        }


        // 删掉树上的word--delete.先判断有没有字符串，有的话，沿途pass--，最后一个end--。
        // 若是最后一个字符串，沿途可能存在节点p = e = 0的情况。如果存在p = 0 的时候，就需要把节点置为空，避免内存溢出
        public void delete(String str){
            if (search(str) == 0){
                return;
            }
            Node node = root;
            node.pass--;
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                int path = ch[i] - 'a';
                // 存在p = 0 的时候，就需要把节点置为空，后续空节点交给jvm处理，避免内存溢出
                if (--node.nexts[path].pass == 0) {
                    node.nexts[path] = null;
                    return;
                }
                    node = node.nexts[path];
            }
            node.end--;
        }
    }
}

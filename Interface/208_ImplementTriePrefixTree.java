/*
208. Implement Trie (Prefix Tree)

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

*/

class TrieNode
{
    private TrieNode [] children;
    private boolean isEnd;

    public TrieNode()
    {
        children = new TrieNode[26]; // each for an alphabet
    }

    public boolean hasChar(char ch)
    {
        return (children[ch - 'a'] != null);
    }

    public TrieNode putChar(char ch)
    {
        if (!hasChar(ch))
            children[ch - 'a'] = new TrieNode();
        return children[ch - 'a'];
    }

    public TrieNode getChar(char ch)
    {
        return children[ch - 'a'];
    }
    public void setEnd()
    {
        this.isEnd = true;
    }
    public boolean isEnd()
    {
        return this.isEnd;
    }
}

class Trie
{
    private TrieNode  root;

    public Trie()
    {
        root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode node = this.root;

        for (char ch : word.toCharArray())
            node = node.putChar(ch);

        node.setEnd(); // last node in the chain
    }

    public TrieNode getWordNode(String word)
    {
        TrieNode node = this.root;

        for (char ch : word.toCharArray())
        {
            node = node.getChar(ch);
            if (node == null)
                break;
        }
        return node;
    }

    public boolean search(String word)
    {
        TrieNode node = getWordNode(word);

        return (node != null) && (node.isEnd());
    }

    public boolean startsWith(String prefix)
    {
        return getWordNode(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

import java.util.PriorityQueue

class Node constructor(
    var item: Int,
    var char: Char,
    var left: Node?,
    var right: Node?
)

class ImplementComparator: Comparator<Node> {
    public override fun compare(x: Node, y: Node): Int {
        return x.item - y.item
    }
} 

class Huffman {
    var tempCode: LinkedHashMap<Char, String> = linkedMapOf()
    var huffmanCode: LinkedHashMap<Char, String> = linkedMapOf()
    
    public fun getKeyByValue(map: LinkedHashMap<Char, String>, target: String): Char {
        for ((key, value) in map)
        {
            if (target == value) {
                return key
            }
        }
        return ' '
	}
    
    public fun stringToMap(str: String): LinkedHashMap<Char, Int> {
        var map: LinkedHashMap<Char, Int> = linkedMapOf()
        
        for (char in str) {
            val temp: Int? = map.get(char)
            
            if (char in getKeysFromMap(map)) {
                if (temp != null) {
                	map.put(char, temp + 1)
                }
                else {
                    map.put(char, 1)
                }
            }
            else {
                map.put(char, 1)
            }
        }
        
        return map
    }
    
    public fun buildEncodedSentence (map: LinkedHashMap<Char, String>, sentence: String): String {
        var encodedSentence: String = ""
        
        for (sentenceChar in sentence) {
            encodedSentence += map.get(sentenceChar)
        }
        
        return encodedSentence
    }
    
    public fun encode(sentence: String): LinkedHashMap<Char, Int> {
        return stringToMap(sentence)
    }
    
	public fun printCode(root: Node?, str: String) {
        if (root == null) {
            return
        }
        
        if (root.left == null && root.right == null && (Character.isLetter(root.char) || root.char == ' ')) {            
            tempCode.put(root.char, str)
            
            return
        }
        
        printCode(root.left, str + "0")
        printCode(root.right, str + "1")
    }
    
    public fun buildDecodedSentence(encodedSentence: String, encodedMap: LinkedHashMap<Char, String>): String {
        var decodedSentence: String = ""
        var temp: String = ""
        
        for (sentenceCode in encodedSentence) {
            temp += sentenceCode
            
            if (temp in getStringValuesFromEncodedMap(encodedMap)) {
                decodedSentence += getKeyByValue(encodedMap, temp)
                temp = ""
            }
        }
        
        return decodedSentence
    }
    
    public fun main(map: LinkedHashMap<Char, Int>): LinkedHashMap<Char, String> {
        val charList = getKeysFromMap(map) 
        val charFreq = getIntValuesFromMap(map)
        val charListSize = charList.size
        
        val priorityQueue = PriorityQueue<Node>(charListSize, ImplementComparator())
        
        for (i in 0..charListSize - 1) {
            var huffmanNode = Node(
                item = charFreq[i],
                char = charList[i],
                left = null,
                right = null
            )
            
            priorityQueue.add(huffmanNode)          
        }
        
        var root: Node = Node(
        	item = 0,
            char = ' ',
            left = null,
            right = null
        )
        
        while (priorityQueue.size > 1) {
            val x = priorityQueue.poll()
            val y = priorityQueue.poll()
            
            var currentNode = Node(item = x.item + y.item, char = '-', left = x, right = y)
            root = currentNode
            
            priorityQueue.add(currentNode)
        }
        
        printCode(root, "")
        val temp = tempCode.toList().sortedBy { (key, value) -> key }
        
        for ((key, value) in temp) {
            huffmanCode.put(key, value)
        }
        
        return huffmanCode
    }
    
    public fun getKeysFromMap(map: LinkedHashMap<Char, Int>): MutableList<Char> {
        var mapKeys = mutableListOf<Char>()
        
        for ((key, value) in map) {
            mapKeys.add(key)
        }
        
        return mapKeys
    }
    
    public fun getIntValuesFromMap(map: LinkedHashMap<Char, Int>): MutableList<Int> {
        var mapValues = mutableListOf<Int>()
        
        for ((key, value) in map) {
            mapValues.add(value)
        }
        
        return mapValues
    }
    
    public fun getStringValuesFromEncodedMap(map: LinkedHashMap<Char, String>): MutableList<String> {
        var mapValues = mutableListOf<String>()
        
        for ((key, value) in map) {
            mapValues.add(value)
        }
        
        return mapValues
    }
}

fun main() {
    println("Huffman Code (P50a): ")
    val p50a = Huffman()
    println(p50a.main(linkedMapOf(Pair('a', 25), Pair('b', 21), Pair('c', 18), Pair('d', 14), Pair('e', 9), Pair('f', 7), Pair('g', 6))))
    
    val sentence = "Eddi macht Feierabend"
    
    val p50b = Huffman()
    println("\nHuffman Code (P50b, encoded): ")
    val encodedP50b = p50b.buildEncodedSentence(p50b.main(p50b.encode(sentence)), sentence)
    println(encodedP50b)
    
    println("\nHuffman Code (P50b, decoded): ")
    println(p50b.buildDecodedSentence(encodedP50b, p50b.main(p50b.encode(sentence))))
    
}
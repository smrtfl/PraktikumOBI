import java.util.PriorityQueue

class Node constructor(
    var item: Int,
    var char: Char,
    var left: Node?,
    var right: Node?
) {
}

class ImplementComparator: Comparator<Node> {
    public override fun compare(x: Node, y: Node): Int {
        return x.item - y.item
    }
} 

class Huffman {
	public fun printCode(root: Node?, str: String) {
        if (root == null) {
            return
        }
        
        if (root.left == null && root.right == null && Character.isLetter(root.char)) {
            println(root.char + "\t" + str)
            
            return
        }
        
        printCode(root.left, str + "0")
        printCode(root.right, str + "1")
    }
    
    public fun main(map: LinkedHashMap<Char, Int>) {
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
        
        println("Char\tHuffman code")
        println("--------------------")
        printCode(root, "")
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
}

fun main() {
    val p50 = Huffman()
    p50.main(linkedMapOf(Pair('a', 25), Pair('b', 21), Pair('c', 18), Pair('d', 14), Pair('e', 9), Pair('f', 7), Pair('g', 6)))
}
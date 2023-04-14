class Node(
	var value: Char,
    var left: Node?,
    var right: Node?
)

class balancedBinaryTree(
    val amountOfNodes: Int,
    val treeChar: Char
) 
{
    public var root = Node(treeChar, Node(treeChar, null, null), Node(treeChar, null, null))
    
    var nodeCounter = 1
    
    fun generateTree(currentNode: Node?, depthCounter: Int, isLeftLeaf: Boolean) {
		if (nodeCounter == amountOfNodes) {
            return
        }
        
        if (isLeftLeaf) {
            if (currentNode?.left == null) {
                currentNode?.left = Node(treeChar, null, null)
                nodeCounter++
            }
            
            if (nodeCounter <= amountOfNodes / 2) {
                generateTree(currentNode?.left, depthCounter + 1, true)
            }
            else {
                generateTree(root.right, 0, false)
            }
        }
        else {
            if (currentNode?.right == null) {
                currentNode?.right = Node(treeChar, null, null)
                nodeCounter++
            }
            
            generateTree(currentNode?.right, depthCounter + 1, false)
        }
    }
    
    public fun printTree(currentNode: Node?, temp: Int, height: Int) {
        var space: Int = temp
        
        if (currentNode == null) {
            return
        }
        
        space += height
        
        printTree(currentNode.right, space, height)
        println()
        
        for (i in height..space) {
            print(' ')
        }
        
        print(currentNode.value)
        
        println()
        printTree(currentNode.left, space, height)
    }
    
    private fun isMirror(leftLeaf: Node?, rightLeaf: Node?): Boolean {
        if (leftLeaf == null && rightLeaf == null) {
            return true
        }
        else if (leftLeaf == null || rightLeaf == null) {
            return false
        }
        else {
            return leftLeaf.value == rightLeaf.value && isMirror(leftLeaf.left, rightLeaf.right) && isMirror(leftLeaf.right, rightLeaf.left)
        }
    } 
    
    public fun isSymmetric(currentNode: Node?): Boolean {
        if (currentNode == null) {
            return true
        }
        
        return isMirror(currentNode.left, currentNode.right)
    }
}

fun main() {
    println("Balanced Binary Tree (P55/57): ")
    val tree = balancedBinaryTree(5, 'x')
    tree.generateTree(tree.root, 0, true)
    
    println("Symmetric (P56): ${tree.isSymmetric(tree.root)}")
    tree.printTree(tree.root, 0, 10)    
}
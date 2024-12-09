package common

fun computeChecksum(diskMap: List<Pair<Int, Int>>): Long = diskMap.foldIndexed(0) { index, acc, current -> acc + (index * current.second) }

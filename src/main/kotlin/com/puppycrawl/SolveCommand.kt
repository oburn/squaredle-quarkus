package com.puppycrawl

import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.system.exitProcess

@Command(name = "solve", mixinStandardHelpOptions = true)
class SolveCommand : Runnable {

    @Option(names = ["--minLen"], defaultValue = "4", description = ["Default minimum length."])
    var minLen: Int = 4

    @Option(names = ["--maxLen"], defaultValue = "10", description = ["Default maximum length."])
    var maxLen: Int = 10

    @Option(names = ["--dict"], defaultValue = "/usr/share/dict/words", description = ["Default dictionary"])
    var dictFile: Path = Path.of("usr", "share", "dict", "words")

    @Parameters(paramLabel = "rows", description = ["Rows of the grid"])
    lateinit var rows: List<String>

    override fun run() {
        if (rows.size < 4) {
            println("Not enough rows supplied, got ${rows.size} passed")
            exitProcess(1)
        }
        println("Solving for minLen ${minLen} and maxLen ${maxLen} with ${dictFile} for ${rows}")
        val dict = Dictionary.fromFile(dictFile, minLen, maxLen)
        println("Loaded dictionary")
        val grid = Grid(rows = rows, searcher = dict)
        val paths = grid.solve()
        println("Found ${paths.size} words")
        paths.sortedBy { it.word }
            .forEach { p ->
                println("${p.word} -> ${p.steps}")
            }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            exitProcess(CommandLine(SolveCommand()).execute(*args))
        }
    }
}

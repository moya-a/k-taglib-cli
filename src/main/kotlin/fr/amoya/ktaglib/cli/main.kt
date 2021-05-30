package fr.amoya.ktaglib.cli

import fr.amoya.ktaglib.cli.processor.CliProcessor
import fr.amoya.ktaglib.cli.processor.CliProcessorImpl
import fr.amoya.ktaglib.common.Tag

@ExperimentalUnsignedTypes
fun main(args: Array<String>)
{
  val cli: CliProcessor = CliProcessorImpl("ktaglib", args)
  cli.files.forEach { println(Tag.getTag(it)) }
}

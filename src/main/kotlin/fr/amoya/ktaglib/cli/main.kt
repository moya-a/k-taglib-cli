package fr.amoya.ktaglib.cli

import fr.amoya.ktaglib.cli.processor.CliProcessor
import fr.amoya.ktaglib.cli.processor.CliProcessorImpl
import fr.amoya.ktaglib.common.Tag
import fr.amoya.ktaglib.common.mappers.json.JsonMapper
import kotlinx.serialization.encodeToString

@ExperimentalUnsignedTypes
fun main(args: Array<String>)
{
  val cli: CliProcessor = CliProcessorImpl("ktaglib", args)

  cli.files.map { JsonMapper.format.encodeToString(Tag.getTag(it)) }.forEach(::println)
}

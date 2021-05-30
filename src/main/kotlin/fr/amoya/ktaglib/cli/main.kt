package fr.amoya.ktaglib.cli

import fr.amoya.ktaglib.cli.enums.OutputFormatter
import fr.amoya.ktaglib.common.tags.Tag
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default

@ExperimentalUnsignedTypes
fun main(args: Array<String>)
{

  val parser = ArgParser(programName = "ktagcli")
  val input by parser.argument(
    ArgType.String,
    fullName = "input",
    description = "Input file or directory"
  )
  val format by parser.option(
    ArgType.Choice<OutputFormatter>(),
    fullName = "format",
    shortName = "f",
    description = "Output format"
  ).default(OutputFormatter.JSON)
  val debug by parser.option(
    ArgType.Boolean,
    fullName = "debug",
    shortName = "d",
    description = "Enable debug"
  ).default(false)
  val separator by parser.option(
    ArgType.String,
    fullName = "separator",
    shortName = "s",
    description = "Separator when using multiple inputs"
  ).default(",")
  val multiple by parser.option(
    ArgType.Boolean,
    fullName = "multiple",
    shortName = "m",
    description = "Allow multiple inputs"
  ).default(false)

  parser.parse(args)

  println(input)
  println(format)
  println(debug)
  println(separator)
  println(multiple)

  println(Tag.getTag(input))

  println("Hello World!")
}

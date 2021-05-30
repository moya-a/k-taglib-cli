package fr.amoya.ktaglib.cli

import fr.amoya.ktaglib.cli.enums.OutputFormatter
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default

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

  parser.parse(args)

  println(input)
  println(format)
  println(debug)

  println("Hello World!")
}

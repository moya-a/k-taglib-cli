package fr.amoya.ktaglib.cli.processor

import fr.amoya.ktaglib.cli.enums.OutputFormat
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.default

class CliProcessorImpl constructor(programName: String, args: Array<String>) : CliProcessor
{
  private lateinit var _files: List<String>
  private var _format: OutputFormat = OutputFormat.JSON
  private var _debug: Boolean = false

  init
  {
    process(programName, args)
  }

  override val files: List<String>
    get() = _files
  override val format: OutputFormat
    get() = _format
  override val debug: Boolean
    get() = _debug

  override fun process(programName: String, args: Array<String>)
  {
    val parser = ArgParser(programName)

    val input by parser.argument(
      ArgType.String,
      fullName = "input",
      description = "Input file or directory"
    )
    val format by parser.option(
      ArgType.Choice<OutputFormat>(),
      fullName = "format",
      shortName = "f",
      description = "Output format"
    ).default(OutputFormat.JSON)
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

    _debug = debug
    _format = format
    _files = if (multiple) input.split(separator) else listOf(input)
  }
}

package fr.amoya.ktaglib.cli.processor

import fr.amoya.ktaglib.cli.enums.OutputFormat

interface CliProcessor
{
  val files: List<String>
  val format: OutputFormat
  val debug: Boolean

  fun process(programName: String, args: Array<String>)
}


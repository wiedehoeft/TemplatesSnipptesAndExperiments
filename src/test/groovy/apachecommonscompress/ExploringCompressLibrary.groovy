package apachecommonscompress

import org.apache.commons.compress.archivers.tar.TarArchiveInputStream
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream
import org.junit.Rule
import org.junit.rules.TemporaryFolder

import gradletasks.TarGzCreator
import spock.lang.Specification

class ExploringCompressLibrary extends Specification {

	@Rule final TemporaryFolder testProjectDir = new TemporaryFolder()

	def File tarFile

	def TarGzCreator tarGzCreator

	def setup() {
		tarFile = testProjectDir.newFile("demo.tar.gz")
		tarGzCreator = new TarGzCreator()
	}

	def "create tar for test"() {
		given:
		def file = testProjectDir.newFile("Demo.txt")
		when:
		def tarGzFile = tarGzCreator.create(file, tarFile)

		then:
		tarGzFile.exists()
	}

	def "check content in tar"() {
		given:
		def file = testProjectDir.newFile("Demo.txt")
		def tarGzFile = tarGzCreator.create(file, tarFile)

		when:
		def entry = tarGzCreator.getFirstEntry(tarGzFile)

		then:
		entry.name.equals("Demo.txt")
	}
}

package gradletasks

import org.apache.commons.compress.archivers.tar.TarArchiveEntry
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream
import org.apache.commons.compress.utils.IOUtils

class TarGzCreator {

	def File create(File sourceFile, File tarGzFile) {
		def fOut = new FileOutputStream(tarGzFile)
		def bOut = new BufferedOutputStream(fOut)
		def gzOut = new GzipCompressorOutputStream(bOut)
		def tOut = new TarArchiveOutputStream(gzOut)

		def fileToURIGetPath = sourceFile.toURI().getPath()

		def demoTar = new TarArchiveEntry(sourceFile, sourceFile.getName())

		tOut.putArchiveEntry(demoTar)

		def fi = new FileInputStream(sourceFile)
		BufferedInputStream bis = new BufferedInputStream(fi)
		IOUtils.copy(bis, tOut)
		tOut.closeArchiveEntry()
		tOut.close()

		return tarGzFile
	}

	def TarArchiveEntry getFirstEntry(File tarGzFile) {
		def tarArchiveInputStream = new TarArchiveInputStream(
				new GzipCompressorInputStream(
				new FileInputStream(tarGzFile)))
		return tarArchiveInputStream.getNextTarEntry()
	}
}

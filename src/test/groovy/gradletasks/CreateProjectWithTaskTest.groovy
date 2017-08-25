package gradletasks

import org.gradle.internal.impldep.org.apache.tools.tar.TarOutputStream
import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import static org.gradle.testkit.runner.TaskOutcome.*

import org.apache.commons.compress.archivers.tar.TarArchiveEntry
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream
import spock.lang.Specification

class CreateProjectWithTaskTest extends Specification {

	@Rule final TemporaryFolder testProjectDir = new TemporaryFolder()
	File buildFile

	def setup() {
		buildFile = testProjectDir.newFile('build.gradle')
	}

	def "hello world task prints hello world"() {
		given:
		buildFile << """
            task helloWorld {
                doLast {
                    println 'Hello world!'
                }
            }
        """

		when:
		def result = GradleRunner.create()
				.withProjectDir(testProjectDir.root)
				.withArguments('helloWorld')
				.build()

		then:
		result.output.contains('Hello world!')
		result.task(":helloWorld").outcome == SUCCESS
	}
}

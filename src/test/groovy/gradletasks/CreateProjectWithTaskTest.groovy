package gradletasks

import static org.gradle.testkit.runner.TaskOutcome.*

import org.gradle.testkit.runner.GradleRunner
import org.junit.Ignore
import org.junit.Rule
import org.junit.rules.TemporaryFolder

import spock.lang.Specification

/**
 * This class is currently only an example for using the gradle Testkit. Maybe we use it later
 * for some integration tests.
 *
 */
@Ignore
class CreateProjectWithTaskTest extends Specification {

	@Rule final TemporaryFolder testProjectDir = new TemporaryFolder()
	File buildFile

	def setup() {
		buildFile = testProjectDir.newFile('build.gradle')
		def thirdPartyDir = testProjectDir.newFolder("3rdParty")
	}

	def "create bsm64 directory for application"() {
		def project = testProjectDir.newFolder("ProjectDirStub")
		def buildDir = testProjectDir.newFolder(project.getName(), "gradleBuildDirStub")

		def buildDirPath = buildDir.getPath()
		given:
		buildFile << """
			apply plugin: 'java'
			apply plugin: 'groovy'
			task createBsm64Dir {
				def bsm64Dir = new File($buildDirPath + '/bsm64')
				bsm64Dir.mkDir()
			}
		"""

		when:
		def result = GradleRunner.create()
				.withProjectDir(testProjectDir.root)
				.withArguments('createBsm64Dir')
				.build()

		then:
		buildDir.listFiles().length == 1
		buildDir.listFiles()[0].getName().equals("bsm64")
		result.task(":createBsm64Dir").outcome == SUCCESS
	}


	def "hello world task prints hello world"() {
		given:
		buildFile << """
            task copy3rdParty {
			}
        """

		when:
		def result = GradleRunner.create()
				.withProjectDir(testProjectDir.root)
				.withArguments('copy3rdParty' , "--stacktrace")
				.build()

		then:
		result.output.contains('Hello world!')
		result.task(":helloWorld").outcome == SUCCESS
	}
}

package gradletasks

import org.gradle.CreateDirectoryTask
import org.gradle.api.InvalidUserDataException
import org.gradle.api.tasks.TaskValidationException
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Rule
import org.junit.rules.TemporaryFolder

import spock.lang.Specification

class CreatingAppTaskTest extends Specification {

	@Rule TemporaryFolder temporaryFolder = new TemporaryFolder()

	def "try to create folder without passing needed name arg"() {

		given:
		def project = ProjectBuilder.builder().build()
		CreateDirectoryTask task = project.task('createTargetFolder', type: CreateDirectoryTask)

		when:
		task.execute()

		then:
		TaskValidationException taskValidationException = thrown()
		taskValidationException.cause instanceof InvalidUserDataException
	}

	def "create folder with passed arguments"() {

		given:
		def builder = ProjectBuilder.builder()
		builder.withProjectDir(temporaryFolder.folder)
		def project = builder.build()
		CreateDirectoryTask task = project.task('createTargetFolder', type: CreateDirectoryTask)
		task.directoryName = "demo"

		when:
		task.execute()

		then:
		def folderContent = temporaryFolder.folder.listFiles()
		ignoreHiddenFiles(folderContent).size() == 1
	}

	private def File[] ignoreHiddenFiles(File[] folderContent) {
		folderContent.findAll {
			!it.name.startsWith(".")
		}
	}
}

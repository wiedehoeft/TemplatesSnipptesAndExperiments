package org.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction;

class CreateDirectoryTask extends DefaultTask {

	@Input
	def String directoryName

	@TaskAction
	def File createFolder() {
		def pathToBuildDir = project.getBuildDir().getPath()
		def file = new File(pathToBuildDir + "/" + directoryName)
		file.mkdir()
		return file
	}
}
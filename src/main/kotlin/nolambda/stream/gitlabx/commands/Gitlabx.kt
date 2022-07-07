package nolambda.stream.gitlabx.commands

import com.github.ajalt.clikt.core.CliktCommand
import org.gitlab4j.api.GitLabApi
import org.gitlab4j.api.models.Project


class Gitlabx : CliktCommand() {
    override fun run() {
        val gitLabApi = GitLabApi(
            "https://gitlab.com/",
            System.getenv("GITLAB_GITLABX_TOKEN")
        )

        val ciPlaygroundPid = 33411227L

        val projects: List<Project> = gitLabApi.projectApi.getProjects(0, 10)
        val result = gitLabApi.pipelineApi.getPipelines(ciPlaygroundPid)

        println(result)
    }
}
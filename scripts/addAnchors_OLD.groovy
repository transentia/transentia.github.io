import groovy.io.FileType

new File('./OLD').eachFileMatch(FileType.FILES, ~/\d+.htm/) { file ->

    def fname = file.name

    println "File: ${fname}"
    def lines = []
    def index = 0
    file.eachLine { line ->
        def l
        if (line =~ /<h1 class="entry-title"/) {
            def spaces = line.takeWhile { it =~ /\s/ }.size()
            l = "${' ' * spaces}<a id='${index++}'></a>${line.trim()}"
        } else
            l = line

        lines << l
    }

    new File($/C:\Users\Bob\Desktop\out\${fname}/$) << lines.join('\n')
}

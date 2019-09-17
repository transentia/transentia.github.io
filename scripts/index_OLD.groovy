import groovy.io.FileType

def files = new TreeSet<File>({ a, b ->
    def asub = (a.name - '.htm') as int
    def bsub = (b.name - '.htm') as int
    asub <=> bsub
} as Comparator)

final DIR = './OLD'
def parent = new File(DIR)

println "<h1>Table of Contents</h1>"

parent.eachFileMatch(FileType.FILES, ~/\d+.htm/) { file ->
    files << file
}

files.each { file ->
    final fname = file.name

    println "<h3>Page: <a href='${fname}'>${fname}</a></h3>"
    println '<ul>'

    file.eachLine { line ->
        def matcher = line.trim() =~ /<a id='(?<id>\d+)'><\/a><h1 class="entry-title">(?<title>.*)<\/h1>/
        if (matcher.matches()) {
            println "  <li><a href='${fname}#${matcher.group("id")}'>${matcher.group("title")}</a></li>"
        }
    }
    println '</ul>'
}

//println JsonOutput.prettyPrint(JsonOutput.toJson(jlist))
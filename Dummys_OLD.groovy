import groovy.io.FileType

def dir = new File('./OLD')
dir.eachFileMatch(FileType.FILES, ~/\d+.htm/) { file ->

    def fname = file.name

    def i = (fname - '.htm') as int
    def ni = i + 1
    def nf = "${ni}.htm"
    def ne = new File(dir, nf).exists()
    def pi = i - 1
    def pf = "${pi}.htm"
    def pe = new File(dir, pf).exists()

    println "File: ${fname}; [${ni}: ${ne} => ${nf}]/[${pi} : ${pe} => ${pf}]"
    def lines = []
    def index = 0
    file.eachLine { line ->
        def l = line
        if (ne && l =~ /<a href="DUMMY">Next »<\/a>/) {
            l = l.replace('DUMMY">Next', "${nf}\">Next")
        }
        if (pe && l =~ /<a href="DUMMY">« Previous<\/a>/) {
            l = l.replace('DUMMY">« Previous', "${pf}\">« Previous")
        }

        lines << l
    }

//    println lines.join('\n')

    new File($/C:\Users\Bob\Desktop\out\${fname}/$) << lines.join('\n')
}

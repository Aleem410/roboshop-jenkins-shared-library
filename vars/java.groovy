def call() {
    if (!env.SONAR_OPTS) {
        env.SONAR_OPTS = ""
    }
    node {

        common.checkout()
        common.compile(java)
        common.codeQuality()
        common.testCases(java)
        if(env.TAG_NAME ==~ "") {
        common.release()
        }

    }
}
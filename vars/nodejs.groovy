def call() {
    if (!env.SONAR_OPTS) {
        env.SONAR_OPTS = ""
    }
    node {

        common.checkout()
        common.codeQuality()
        common.testCases(nodejs)
        if(env.TAG_NAME ==~ "") {
            common.release()
        }

    }
}
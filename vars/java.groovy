def call() {
    node {

        common.checkout()
        common.compile()
        common.codeQuality()
        common.release()

    }
}
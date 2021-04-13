package processorExercise;

    public class Computer {

        private Processor processor = new Processor();

        public int compute(int a, int b) {
            if (processor.process()) {
                return a + b;
            } else {
                return a * b;
            }
        }
}

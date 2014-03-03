package itb.ai.tubes1.controller.ga;

public interface IterationListener<C extends Chromosome<C>, T extends Comparable<T>> {

	void update(GeneticAlgorithm<C, T> environment);

}

package linearregression;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//import java.util.arrays.asList estático;

 public class LinearRegression {
    private static final List<Integer> x = asList(2, 3, 5, 7, 9, 11, 14);  // Códigos de desarrollador de horas consecutivas
    private static final List<Integer> y = asList(4, 5, 7, 10, 15, 20, 40);  // Número de errores producidos

    private static Double predictForValue(int predictForDependentVariable) {
        if (x. size() != y. size())
            throw new IllegalStateException("Debe tener puntos de datos X e Y iguales" );

        Integer numberOfDataValues = x. size();

        List<Double> xSquared = x
                .stream()
 .map(position -> Math.pow(position, 2))
 .collect(Collectors. toList());

        List<Integer> xMultipliedByY = IntStream.range(0, numberOfDataValues)
 .map(i -> x. get(i) * y. get(i))
                .boxed()
 .collect(Collectors. toList());

        Integer xSummed = x
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Integer ySummed = y
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Double sumOfXSquared = xSquared
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Integer sumOfXMultipliedByY = xMultipliedByY
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        int slopeNominator = numberOfDataValues * sumOfXMultipliedByY - ySummed * xSummed;
        Double slopeDenominator = numberOfDataValues * sumOfXSquared - Math. pow(xSummed, 2);
        Double slope = slopeNominator / slopeDenominator;

        double interceptNominator = ySummed - slope * xSummed;
        double interceptDenominator = numberOfDataValues;
        Double intercepción = interceptNominator / interceptDenominator;

        return (slope * predictForDependentVariable) + intercepción;
    }

    public static void main(String[] args) {
        System.out. println(predictForValue(13));
    }
}

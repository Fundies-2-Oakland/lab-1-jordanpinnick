public class Vector3D {
    double vectorX;
    double vectorY;
    double vectorZ;

    public Vector3D(double x, double y, double z) {
        vectorX = x;
        vectorY = y;
        vectorZ = z;
    }

    public double getVectorX() {
        return vectorX;
    }
    public double getVectorY() {
        return vectorY;
    }
    public double getVectorZ() {
        return vectorZ;
    }

    public String toString() {
        return String.format("(%.2f,%.2f,%.2f)",vectorX, vectorY, vectorZ);
    }

    public double getMagnitude() {
        return Math.sqrt(vectorX * vectorX + vectorY * vectorY + vectorZ * vectorZ);
    }

    public Vector3D normalize() {
        double magnitude = getMagnitude();

        if(magnitude == 0) {
            throw new IllegalStateException();
        }

        return new Vector3D(vectorX / magnitude,vectorY / magnitude,vectorZ / magnitude);
    }

    public Vector3D add(Vector3D vector) {
        return new Vector3D(vectorX + vector.vectorX, vectorY + vector.vectorY, vectorZ + vector.vectorZ)
    }

    public Vector3D multiply(double constant) {
        return new Vector3D(vectorX * constant, vectorY * constant, vectorZ * constant);
    }

    public double dotProduct(Vector3D vector) {
        return vectorX * vector.vectorX + vectorY * vector.vectorY + vectorZ * vector.vectorZ;
    }

    public double angleBetween(Vector3D vector) {
        double magnitude1 = getMagnitude();
        double magnitude2 = vector.getMagnitude();

        double denominator = magnitude1 * magnitude2;

        if(denominator == 0) {
            throw new IllegalStateException();
        }

        return Math.acos(dotProduct(vector) / denominator);
    }

    public Vector3D crossProduct(Vector3D vector) {
        double uX = vectorY * vector.vectorZ - vectorZ * vector.vectorY;
        double uY = vectorZ * vector.vectorX - vectorX * vector.vectorZ;
        double uZ = vectorX * vector.vectorY - vectorY * vector.vectorX;

        return new Vector3D(uX, uY, uZ);
    }
}

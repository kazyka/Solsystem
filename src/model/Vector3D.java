package model;
/**
 * Vector3D is a class that extends Matrix and represents a 3 x 1 matrix
 */
public class Vector3D extends Matrix{

    public Vector3D(double x, double y, double z){
        super(3, 1);
        setX(x);
        setY(y);
        setZ(z);
    }

    /**
     * sets a value at a given position in the matrix
     * @param m any given value
     */
    public Vector3D(Matrix m){
        super(3, 1);
        setX(m.get(1, 1));
        setY(m.get(2, 1));
        setZ(m.get(3, 1));
    }

    /**
     *
     * @param m any matrix to use
     * @return return any given value
     */
    public Vector3D add(Vector3D m){
        return new Vector3D(super.add(m));
    }

    /**
     *
     * @param m any matrix to use
     * @return a new matrix
     */
    public Vector3D mul(double m){
        return new Vector3D(super.mul(m));
    }

    /**
     *
     * @param m any matrix to use
     * @return a new matrix
     */
    public Vector3D sub(Vector3D m){
        return new Vector3D(getX()-m.getX(),getY()-m.getY(),getZ()-m.getZ());
    }

    /**
     *
     * @param m any matrix to use
     * @return a new matrix
     */
    public Vector3D ska(double m){
        return new Vector3D(m * getX(), m * getY(), m * getZ());
    }

    public double getX(){
        return get(1, 1);
    }

    public double getY(){
        return get(2, 1);
    }

    public double getZ(){
        return get(3, 1);
    }

    public void setX(double m){
        this.set(1, 1, m);
    }

    public void setY(double m){
        this.set(2, 1, m);
    }

    public void setZ(double m){
        this.set(3, 1, m);
    }
    
    
    public String toString(){
    	return "("+String.format("%.5f", getX()) + "; "+ String.format("%.5f", getY()) + "; " + String.format("%.5f", getZ())+")";
    }

}

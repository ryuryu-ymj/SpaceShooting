package spaceShooting;

public class ThreeD
{
	public static PlaneVector getPlanePointFromCubicPoint(CubicVector cubicPoint, CubicVector cameraPoint, double cameraAngleXY, double cameraAngleYZ)
	{
		PlaneVector planePoint = new PlaneVector();

		double pointAngleXY = Math.atan2(cubicPoint.y - cameraPoint.y, cubicPoint.x - cameraPoint.x);
		double lengthXY = Math.sqrt(Math.pow((cubicPoint.x - cameraPoint.x), 2) + Math.pow((cubicPoint.y - cameraPoint.y), 2));
		planePoint.x = Play.DISPLAY_WIDTH / 2 + (float) (lengthXY * Math.sin(pointAngleXY - cameraAngleXY));
		System.out.println(lengthXY + " * " + Math.sin(pointAngleXY - cameraAngleXY) + " = " + planePoint.x + "  (pointAngleXY - cameraAngleXY) = " + (pointAngleXY - cameraAngleXY));

		double pointAngleYZ = Math.atan2(cubicPoint.y - cameraPoint.y, cubicPoint.z - cameraPoint.z);
		double lengthYZ = Math.sqrt(Math.pow((cubicPoint.z - cameraPoint.z), 2) + Math.pow((cubicPoint.y - cameraPoint.y), 2));
		planePoint.y = Play.DISPLAY_HEIGHT / 2 + (float) (lengthYZ * Math.sin(pointAngleYZ - cameraAngleYZ));

		return planePoint;
	}
}
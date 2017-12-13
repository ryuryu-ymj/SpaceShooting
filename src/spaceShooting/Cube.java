package spaceShooting;

/**
 * 立体の処理
 * @author ryuryu
 *
 */
public class Cube
{
	/**
	 * 空間ベクトルを平面ベクトルに変換する
	 * @param cubicPoint 空間ベクトルにおける表示点の座標
	 * @param cameraPoint 空間ベクトルにおけるカメラの座標
	 * @param cameraAngleXY カメラのxy平面の向く角度
	 * @param cameraAngleYZ カメラのyz平面の向く角度
	 * @return 平面ベクトルにおける表示点の座標
	 */
	public static PlaneVector getPlanePointFromCubicPoint(CubicVector cubicPoint, CubicVector cameraPoint, double cameraAngleXY, double cameraAngleYZ)
	{
		PlaneVector planePoint = new PlaneVector();

		double pointAngleXY = Math.atan2(cubicPoint.y - cameraPoint.y, cubicPoint.x - cameraPoint.x);
		double lengthXY = Math.sqrt(Math.pow((cubicPoint.x - cameraPoint.x), 2) + Math.pow((cubicPoint.y - cameraPoint.y), 2));
		planePoint.x = Play.DISPLAY_WIDTH / 2 + (float) (lengthXY * Math.sin(pointAngleXY - cameraAngleXY - Math.PI / 2));
		//System.out.println(lengthXY + " * " + Math.sin(pointAngleXY - cameraAngleXY) + " = " + planePoint.x + "  (pointAngleXY - cameraAngleXY) = " + (pointAngleXY - cameraAngleXY));

		double pointAngleYZ = Math.atan2(cubicPoint.y - cameraPoint.y, cubicPoint.z - cameraPoint.z);
		double lengthYZ = Math.sqrt(Math.pow((cubicPoint.z - cameraPoint.z), 2) + Math.pow((cubicPoint.y - cameraPoint.y), 2));
		planePoint.y = Play.DISPLAY_HEIGHT / 2 + (float) (lengthYZ * Math.sin(pointAngleYZ - cameraAngleYZ - Math.PI / 2));

		return planePoint;
	}
}
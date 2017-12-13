package spaceShooting;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 * ゲームオブジェクトの管理クラス.
 * オブジェクトのインスタンスを持ち,
 * オブジェクト同士の相互作用(衝突処理など)を一括管理する.
 */
public class ObjectPool
{
	CubicVector cameraPoint = new CubicVector(0, 0, 0);
	double cameraAngleXY = 0;
	double cameraAngleYZ = 0;
	CubicVector cubicPoint1 = new CubicVector(200, 0, 0);
	CubicVector cubicPoint2 = new CubicVector(-200, 0, 0);
	CubicVector cubicPoint3 = new CubicVector(0, 200, 200);
	CubicVector cubicPoint4 = new CubicVector(0, 200, 0);
	CubicVector cubicPoint5 = new CubicVector(0, 0, -200);

	ObjectPool()
	{
	}

	/**
	 * 初期化処理.
	 */
	public void init()
	{
	}

	/**
	 * ステップごとの更新.
	 */
	public void update(GameContainer gc)
	{
	}

	/**
	 * ステップごとの描画処理.
	 */
	public void render(Graphics g)
	{
		cameraAngleXY += 0.01;
		cameraAngleYZ += 0.01;

		PlaneVector planePoint1 = Cube.getPlanePointFromCubicPoint(cubicPoint1, cameraPoint, cameraAngleXY, cameraAngleYZ);
		PlaneVector planePoint2 = Cube.getPlanePointFromCubicPoint(cubicPoint2, cameraPoint, cameraAngleXY, cameraAngleYZ);
		PlaneVector planePoint3 = Cube.getPlanePointFromCubicPoint(cubicPoint3, cameraPoint, cameraAngleXY, cameraAngleYZ);
		PlaneVector planePoint4 = Cube.getPlanePointFromCubicPoint(cubicPoint4, cameraPoint, cameraAngleXY, cameraAngleYZ);
		PlaneVector planePoint5 = Cube.getPlanePointFromCubicPoint(cubicPoint5, cameraPoint, cameraAngleXY, cameraAngleYZ);

		g.setColor(Color.black);
		g.drawLine(planePoint1.x, planePoint1.y, planePoint2.x, planePoint2.y);
		g.drawLine(planePoint3.x, planePoint3.y, planePoint2.x, planePoint2.y);
		g.drawLine(planePoint1.x, planePoint1.y, planePoint3.x, planePoint3.y);
		g.drawLine(planePoint1.x, planePoint1.y, planePoint4.x, planePoint4.y);
		g.drawLine(planePoint4.x, planePoint4.y, planePoint2.x, planePoint2.y);
		g.drawLine(planePoint4.x, planePoint4.y, planePoint3.x, planePoint3.y);
		g.drawLine(planePoint1.x, planePoint1.y, planePoint5.x, planePoint5.y);
		g.drawLine(planePoint5.x, planePoint5.y, planePoint2.x, planePoint2.y);
		g.drawLine(planePoint5.x, planePoint5.y, planePoint3.x, planePoint3.y);
		g.drawLine(planePoint5.x, planePoint5.y, planePoint4.x, planePoint4.y);
		//System.out.println(planePoint1.x + " " + planePoint1.y + " " + planePoint2.x + " " + planePoint2.y);
	}

	/**
	 * 配列内のすべてのインスタンスを無効にする.
	 *
	 * @param object ゲームオブジェクトの配列
	 */
	private void deactivateObjects(GameObject[] object)
	{
		for (GameObject obj : object)
		{
			obj.active = false;
		}
	}

	/**
	 * 配列内のインスタンスのうち,有効な物のみを更新する.
	 *
	 * @param object ゲームオブジェクトの配列
	 */
	private void updateObjects(GameObject[] object, GameContainer gc)
	{
		for (GameObject obj: object)
		{
			if (obj.active)
			{
				obj.update(gc);
			}
		}
	}

	/**
	 * 配列内のインスタンスのうち,有効な物のみを描画する.
	 *
	 * @param object ゲームオブジェクトの配列
	 */
	private void renderObjects(GameObject[] object, Graphics g)
	{
		for (GameObject obj : object)
		{
			if (obj.active)
			{
				obj.render(g);
			}
		}
	}
}

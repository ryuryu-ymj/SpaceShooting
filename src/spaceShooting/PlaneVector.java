package spaceShooting;

/**
 * 平面ベクトル
 * @author ryuryu
 *
 */
public class PlaneVector
{
	/**
	 * 平面ベクトルの成分
	 */
	public float x, y;

	/**
	 * コンストラクタ
	 */
	public PlaneVector()
	{
		x = 0;
		y = 0;
	}

	/**
	 * コンストラクタ
	 * @param x 平面ベクトルのx成分
	 * @param y 平面ベクトルのy成分
	 */
	public PlaneVector(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
}

package spaceShooting;

/**
 * 空間ベクトル
 * @author ryuryu
 *
 */
public class CubicVector
{
	/**
	 * 空間ベクトルの成分
	 */
	public float x, y, z;

	/**
	 * コンストラクタ
	 */
	public CubicVector()
	{
		x = 0;
		y = 0;
		z = 0;
	}

	/**
	 * コンストラクタ
	 * @param x 空間ベクトルのx成分
	 * @param y 空間ベクトルのy成分
	 * @param z 空間ベクトルのz成分
	 */
	public CubicVector(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

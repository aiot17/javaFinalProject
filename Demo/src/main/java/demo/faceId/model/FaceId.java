package demo.faceId.model;

public class FaceId {
	private static String faceId;
	private static String token;

	public static String getToken() {
		return token;
	}

	public static void setToken(String token) {
		FaceId.token = token;
	}

	public static String getFaceId() {
		return faceId;
	}

	public static void setFaceId(String faceId) {
		FaceId.faceId = faceId;
	}
}

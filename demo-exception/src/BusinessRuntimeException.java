public class BusinessRuntimeException extends RuntimeException {
  private int code;

  private BusinessRuntimeException(SysCode sysCode) {
    super(sysCode.getMessage());
    this.code = sysCode.getCode();
  }

  public static BusinessRuntimeException of(SysCode sysCode) {
    return new BusinessRuntimeException(sysCode);
  }

  public int getCode() {
    return code;
  }

  public static class ArrayIndexOutOfRange extends RuntimeException {}


  // main method
  public static void main(String[] args) {
    // test
    try {
      int[] arr = new int[3];
      int result = arr[-1];
      System.out.println(result);
    } catch (RuntimeException e) {
      // Re-throw
      if (e instanceof ArrayIndexOutOfBoundsException) {
        throw new ArrayIndexOutOfRange();
      }
    }
    



  }
}

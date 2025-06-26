public  class Main {
    public static void main(String[] args) {
        String input = "aaabbc";

        char current = input.charAt(0);

        int count = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == current) {
                count++;
                current = input.charAt(i);
            } else {
                sb.append(current);
                sb.append(count);
                current = input.charAt(i);
                count = 1;
            }
            if (i == input.length() - 1) {
                sb.append(current);
                sb.append(count);
            }
            String result = sb.toString();

            System.out.println(result);
        }
    }
}
public class TableTemplate {
    public TableTemplate() {}

    public static final String TABLE_TEMPLATE = """
        +—— 1 — 2 — 3 —+— 4 — 5 — 6 —+— 7 — 8 — 9 ——+
        1   %s   %s   %s  |  %s   %s   %s  |  %s   %s   %s   |
        |              |             |              |
        2   %s   %s   %s  |  %s   %s   %s  |  %s   %s   %s   |
        |              |             |              |
        3   %s   %s   %s  |  %s   %s   %s  |  %s   %s   %s   |
        +——————————————+—————————————+——————————————+
        4   %s   %s   %s  |  %s   %s   %s  |  %s   %s   %s   |
        |              |             |              |
        5   %s   %s   %s  |  %s   %s   %s  |  %s   %s   %s   |
        |              |             |              |
        6   %s   %s   %s  |  %s   %s   %s  |  %s   %s   %s   |
        +——————————————+—————————————+——————————————+
        7   %s   %s   %s  |  %s   %s   %s  |  %s   %s   %s   |
        |              |             |              |
        8   %s   %s   %s  |  %s   %s   %s  |  %s   %s   %s   |
        |              |             |              |
        9   %s   %s   %s  |  %s   %s   %s  |  %s   %s   %s   |
        +——————————————+—————————————+——————————————+
    """;
}

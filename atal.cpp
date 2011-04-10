#include <cstdio>
#include <cmath>
#include <cstring>

#define N 55
#define INF 100000000
#define max(a, b) ((a) > (b) ? (a) : (b))
#define min(a, b) ((a) < (b) ? (a) : (b))
#define eq(a, b) ((a) - (b)) < 0.000001

double cost[N][N];
int n, max_match;
double lx[N], ly[N];
int xy[N];
int yx[N];
bool S[N], T[N];
double slack[N];
double slackx[N];
double prev[N];

void init_labels();
void augment();
void update_labels();
double hungarian();
void add_to_tree(int x, double prevx);

int main()
{
    int banks;
    int cruisers;
    while (1)
    {
        scanf("%d %d",&banks, &cruisers);

        if (!cruisers)
        {
            break;
        }

        n = max(banks, cruisers);

        for (int i = 0; i < banks; i++)
        {
            for (int j = 0; j < cruisers; j++)
            {
                scanf("%lf", &cost[i][j]);
                cost[i][j] *= -1;
            }
        }

        if (n > banks)
        {
            for (int i = banks; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    cost[i][j] = 0;
                }
            }
        }

        double average = -floor(hungarian()/n);

        printf("%.2lf\n", average);
    }

    return 0;
}

void init_labels()
{
    memset(lx, 0, sizeof(lx));
    memset(ly, 0, sizeof(ly));
    for (int x = 0; x < n; x++)
        for (int y = 0; y < n; y++)
            lx[x] = max(lx[x], cost[x][y]);
}

void augment()
{
    if (max_match == n) return;
    int x, y, root;
    double q[N];
    int wr = 0, rd = 0;
    memset(S, false, sizeof(S));
    memset(T, false, sizeof(T));
    memset(prev, -1, sizeof(prev));
    for (x = 0; x < n; x++)
        if (xy[x] == -1)
        {
            q[wr++] = root = x;
            prev[x] = -2;
            S[x] = true;
            break;
        }

    for (y = 0; y < n; y++)
    {
        slack[y] = lx[root] + ly[y] - cost[root][y];
        slackx[y] = root;
    }

    while (true)
    {
        while (rd < wr)
        {
            x = q[rd++];
            for (y = 0; y < n; y++)
                if (eq(cost[x][y] , lx[x] + ly[y]) &&  !T[y])
                {
                    if (yx[y] == -1) break;
                    T[y] = true;
                    q[wr++] = yx[y];
                    add_to_tree(yx[y], x);
                }
            if (y < n) break;
        }
        if (y < n) break;
        update_labels();
        wr = rd = 0;
        for (y = 0; y < n; y++)
            if (!T[y] &&  eq(slack[y], 0))
            {
                if (yx[y] == -1)
                {
                    x = slackx[y];
                    break;
                }
                else
                {
                    T[y] = true;
                    if (!S[yx[y]])
                    {
                        q[wr++] = yx[y];
                        add_to_tree(yx[y], slackx[y]);
                    }
                }
            }
        if (y < n) break;
    }

    if (y < n)
    {
        max_match++;
        for (int cx = x, cy = y, ty; cx != -2; cx = prev[cx], cy = ty)
        {
            ty = xy[cx];
            yx[cy] = cx;
            xy[cx] = cy;
        }
        augment();
    }
}

void update_labels()
{
    int x, y;
    double delta = INF;

    for (y = 0; y < n; y++)
        if (!T[y])
            delta = min(delta, slack[y]);
    for (x = 0; x < n; x++)
        if (S[x]) lx[x] -= delta;
    for (y = 0; y < n; y++)
        if (T[y]) ly[y] += delta;
    for (y = 0; y < n; y++)
        if (!T[y])
            slack[y] -= delta;
}

void add_to_tree(int x, double prevx)
{
    S[x] = true;
    prev[x] = prevx;
    for (int y = 0; y < n; y++)
        if (lx[x] + ly[y] - cost[x][y] < slack[y])
        {
            slack[y] = lx[x] + ly[y] - cost[x][y];
            slackx[y] = x;
        }
}

double hungarian()
{
    double ret = 0;
    max_match = 0;
    memset(xy, -1, sizeof(xy));
    memset(yx, -1, sizeof(yx));
    init_labels();
    augment();
    for (int x = 0; x < n; x++)
        ret += cost[x][xy[x]];
    return ret;
}

